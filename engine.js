var socketio = require('socket.io');
var app = require('./app');

var io = socketio();

var auditorium = io.of('/auditorium');

auditorium.on('connection', function(socket) {
  console.log('user entered an auditorium');
  
  socket.on('disconnect', function() {
    console.log('user has left an auditorium');
  });

  socket.on('user:connected', function() {
    console.log('recieved user:connected');
    auditorium.emit('user:connected', {});
  });

  socket.on('chat:message', function(payload) {
    console.log('chat:message: ', payload);
    auditorium.emit('chat:message', payload);
  })

});

module.exports = io;