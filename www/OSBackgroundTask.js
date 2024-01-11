var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    alert("Hello");
    exec(success, error, 'OSBackgroundTask', 'coolMethod', [arg0]);
}; 
