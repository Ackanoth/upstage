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

  app.controller('StageCtrl', ['$scope', 'Socket', function($scope, Socket) {

    $scope.io = Socket;

    var canv = document.getElementById('stage');
    var cont = document.getElementById('stage-container');
    canv.height = cont.offsetHeight;
    canv.width = cont.offsetWidth;
    $scope.ctx = canv.getContext("2d");
    $scope.isDrawing = false;

    $scope.mouseDown = function(e) {
      $scope.isDrawing = true;
      $scope.io.emit('stage:start_draw', { x: e.pageX, y: e.pageY });
      $scope.startDrawing(e.pageX, e.pageY);
    };
    $scope.mouseMove = function(e) {
      if ($scope.isDrawing) {
        $scope.io.emit('stage:draw', { x: e.pageX, y: e.pageY });
        $scope.draw(e.pageX, e.pageY);
      }
    };
    $scope.mouseUp = function(e) {
      $scope.isDrawing = false;
      $scope.io.emit('stage:finish_draw', { x: e.pageX, y: e.pageY });
      $scope.finishDrawing();
    };

    $scope.startDrawing = function(x, y) {
      $scope.ctx.beginPath();
      $scope.ctx.moveTo(x, y);
    };
    $scope.draw = function(x, y) {
      $scope.ctx.lineTo(x, y);
      $scope.ctx.strokeStyle = "#000";
      $scope.ctx.stroke();
    };
    $scope.finishDrawing = function() {
      $scope.ctx.closePath();
    }

    $scope.io.on('stage:start_draw', function(data) {
      $scope.startDrawing(data.x, data.y);
    });

    $scope.io.on('stage:draw', function(data) {
      $scope.draw(data.x, data.y);
    });

    $scope.io.on('stage:finish_draw', function(data) {
      $scope.finishDrawing();
    });

  }]);
}).call(this);