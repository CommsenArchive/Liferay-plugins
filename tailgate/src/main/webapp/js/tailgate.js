$=jQuery;

var tailgateInstances = new Array(); 

function Tailgate(lines, url) {
	this.lines=lines
	this.url=url
}

function startReading (tailgateNamespace) {
	var tailgate = tailgateInstances[tailgateNamespace];
	$.get(tailgate.url, addLines(tailgateNamespace));
	$(document).everyTime(
		1000,  // every second 
		"reading_"+tailgateNamespace, 
		function(i) {
			$.get(tailgate.url, addLines(tailgateNamespace));
		}, 
		0     // unlimited times
	);
	$('#' + tailgateNamespace + 'list').addClass("tailgateRunnig")
}

function stopReading (tailgateNamespace) {
	$(document).stopTime("reading_"+tailgateNamespace);
	$('#' + tailgateNamespace + 'list').removeClass("tailgateRunnig")
}

var addLines = function(namespace) {
    return function(data, textStatus) {
		jQuery('#'+namespace+'list').append(data);

		// delete first lines if too long 				
		var maxLines = tailgateInstances[namespace].lines;
		var lines = jQuery('#' + namespace + 'list li').length;
		if (lines > maxLines) {
			jQuery('#' + namespace + 'list li').slice(0, lines - maxLines).remove();
		}
    };
};


//$(document).ready(function() {
//  var refreshId = setInterval(function() {
//	  	for (tailgateNamespace in tailgateInstances) { 
//	  		var tailgate = tailgateInstances[tailgateNamespace];
//	  		$.get(tailgate.url, addLines(tailgateNamespace));
//
//			// delete first lines if too long 				
//			var maxLines = tailgate.lines;
//			var lines = jQuery('#'+tailgateNamespace+'list li').length;
//			if (lines > maxLines) {
//				jQuery('#'+tailgateNamespace+'list li').slice(0, lines - maxLines).remove();
//			}
//	  	}
//  }, 1000);
//});