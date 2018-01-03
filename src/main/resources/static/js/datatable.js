$(document).ready( function () {
	 var table = $('#parcelsTable').DataTable({
			"sAjaxSource": "/api/v1/parcels",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
			    { "mData": "plotName"}
			]
	 })
});