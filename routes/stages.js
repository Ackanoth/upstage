var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/:stagename', function(req, res, next) {
  res.render('stage', { title: req.params.stagename });
});

module.exports = router;
