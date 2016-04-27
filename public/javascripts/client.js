(function() {
  var app = angular.module('upstage', []);

  app.factory('Socket', function() {
    var socket = io('/auditorium');
    return socket;
  });

  app.controller('ChatCtrl', ['$scope', 'Socket', function($scope, Socket) {
    $scope.io = Socket;
    $scope.messages = [];
    $scope.io.emit('user:connected', {});

    $scope.io.on('user:connected', function() {
      $scope.messages.push({ txt: 'User connected' });
      $scope.$apply();
    });

    $scope.io.on('chat:message', function(data) {
      $scope.messages.push(data);
      $scope.$apply();
    })

    $scope.sendMessage = function() {
      $scope.io.emit('chat:message', $scope.newMessage);
      $scope.newMessage.txt = '';
    }
  }]);
}).call(this);