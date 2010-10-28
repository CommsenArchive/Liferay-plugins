/**
 *	This file is part of Tailgate Liferay plug-in.
 *	
 * Tailgate Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Tailgate Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tailgate Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */


//$=jQuery;

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
