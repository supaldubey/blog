
var http = require("http");
var url = require("url");
var databaseUrl = "supal:key@localhost/supaldubey"; 
var collections = ["users"]

var db = require("mongojs").connect(databaseUrl, collections, function(){
	console.log("Connected  "+db);
});


function onRequest(request, response) {
var _url = url.parse(request.url, true);
var pathname = _url.pathname;
console.log("Request for " + pathname + " received.");
var content = "Howdy!!<br> Have you requested for the page "+pathname ;
content += "<br><br>Below is a list of saved users - <ul>";

if(pathname == '/addUser' && _url.query['name'])
{
	console.log('Attempting to save the user ' + _url.query['name']);
	db.users.save({name: _url.query['name'], mail: _url.query['mail']}, function(err, saved) {
	if( err || !saved ) 
	{	
	console.log("User not saved");
	}
	else 
	{
		console.log("User saved");
	}
});
}

db.users.find({}, function(err, users) {
  if( err || !users) 
  {
	console.log("No users found");
  }
  else 
  {
	users.forEach( function(user) {
	console.log("User Found "+user.name	);
	content += "<li>"+user.name+ " = "+ user.mail +"</li>";
  });
  }
  content += "</ul>";

response.writeHead(200, {"Content-Type": "text/html"});
response.write(content);
response.end();
});


}

http.createServer(onRequest).listen(8888);
console.log("Server has started.");


 