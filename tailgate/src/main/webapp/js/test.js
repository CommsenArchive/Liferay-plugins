$=jQuery;

$(document).ready(function() {
   var refreshId = setInterval(function() {
      alert('test '+ Math.random());
   }, 9000);
});