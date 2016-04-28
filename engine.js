var debug = require('debug')('upstage:engine');
var socketio = require('socket.io');
var app = require('./app');

var io = socketio();

var auditorium = io.of('/auditorium');

auditorium.on('connection', function(socket) {
  debug('connection');

  socket.on('chat:join', function() {
    debug('chat:join');
    this.broadcast.emit('chat:join');
  });

  socket.on('stage:start_draw', function(data) {
    debug('stage:start_draw', data);
    this.broadcast.emit('stage:start_draw', data);
  });

  socket.on('stage:draw', function(data) {
    debug('stage:draw', data);
    this.broadcast.emit('stage:draw', data);
  });

  socket.on('stage:start_draw', function(data) {
    debug('stage:finish_draw', data);
    this.broadcast.emit('stage:finish_draw', data);
  });

  socket.on('chat:message', function(data) {
    debug('chat:message', data);
    auditorium.emit('chat:message', data);
  })

});

module.exports = io;