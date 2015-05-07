/**
* @author Supal Dubey
* http://roadtobe.com/supaldubey/
**/

var staticHandler = require('./staticHandler');

function dispatch(handler, pathname, req, res) {
   console.log("About to dispatch a request for " + pathname);
   var content = "Hey "+pathname;
  if (typeof handler[pathname] === 'function') {
    content += handler[pathname](req);
	res.writeHead(200, {'Content-Type': 'text/html'});
	res.write(content);
	res.end();
  } else {
    console.log("No request handler found for " + pathname);
	staticHandler.handleStatic(pathname, res);
  }
}

exports.dispatch = dispatch;