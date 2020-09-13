$(document).ready(function() {
    $('.table .editButton').on('click', function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(vehicleHire, status){
            $('#idEdit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);


            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateOutEdit').val(vehicleHire);
            $('#timeOutEdit').val(vehicleHire.timedOut);

            var dateIn = vehicleHire.dateIn.substr(0,10);
            $('#dateInEdit').val(vehicleHire.dateIn);
            $('#ddlClientEdit').val(vehicleHire.clientId);
            $('#ddlLocation1Edit').val(vehicleHire.locationid);
            $('#priceEdit').val(vehicleHire.price);
            $('#remarksEdit').val(vehicleHire.remarks);
        });
        $('#editModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});