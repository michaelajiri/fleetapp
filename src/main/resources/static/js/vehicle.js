$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicle, status) {
            $('#idEdit').val(vehicle.id);
            $('#nameEdit').val(vehicle.name);
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
            $('#vehicleNumberEdit').val(vehicle.vehicleNumber);

            var registrationDate = vehicle.registrationDate.substr(0,10);
            var acquisitionDate = vehicle.acquisitionDate.substr(0,10);
            $('#registrationDateEdit').val(registrationDate);
            $('#acquisitionDateEdit').val(acquisitionDate);

            $('#descriptionEdit').val(vehicle.description);
            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#powerEdit').val(vehicle.power);
            $('#fuelCapacityEdit').val(vehicle.fuelCapacity);
            $('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);
            $('#netWeightEdit').val(vehicle.netWeight);
            $('#ddlEmployeeEdit').val(vehicle.employeeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlLocationEdit').val(vehicle.locationid);
            $('#remarksEdit').val(vehicle.remarks);
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
