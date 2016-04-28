var socketio = require('socket.io');
var app = require('./app');

var io = socketio();

var auditorium = io.of('/auditorium');

auditorium.on('connection', function(socket) {

  socket.on('user:connected', function() {
    auditorium.emit('user:connected');
  });

  socket.on('stage:start_draw', function(data) {
    this.broadcast.emit('stage:start_draw', data);
  });

  socket.on('stage:draw', function(data) {
    this.broadcast.emit('stage:draw', data);
  });

  socket.on('stage:start_draw', function(data) {
    this.broadcast.emit('stage:finish_draw', data);
  });

  socket.on('chat:message', function(payload) {
    auditorium.emit('chat:message', payload);
  })

});

module.exports = io;