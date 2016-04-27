var socketio = require('socket.io');
var app = require('./app');

var io = socketio();

var auditorium = io.of('/auditorium');

auditorium.on('connection', function(socket) {
  console.log('client connected');
  
  socket.on('disconnect', function() {
    console.log('client disconnected');
  });

  socket.on('user:connected', function() {
    auditorium.emit('user:connected');
  });

  socket.on('chat:message', function(payload) {
    console.log('chat:message: ', payload);
    auditorium.emit('chat:message', payload);
  })

});

module.exports = io;