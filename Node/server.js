/**
* @author Supal Dubey
* http://roadtobe.com/supaldubey/
**/

var http = require('http'),
    url = require('url');
	
function start(dispatch, handlers)
{
	http.createServer(function(req, res) {
		var _url = url.parse(req.url).pathname;
		dispatch(handlers, _url, req, res);
	}).listen(8888);
	console.log("Server started !! ");
}

exports.start = start;