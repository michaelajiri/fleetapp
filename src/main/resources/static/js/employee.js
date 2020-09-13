$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (employee, status) {
            $('#idEdit').val(employee.id);
            $('#txtUsernameEdit').val(employee.username);
            $('#firstNameEdit').val(employee.firstName);
            $('#lastNameEdit').val(employee.lastName);
            $('#titleEdit').val(employee.title);
            $('#usernameEdit').val(employee.username);
            $('#SSNEdit').val(employee.socialSecurityNumber);
            $('#genderEdit').val(employee.gender);
            $('#maritalStatusEdit').val(employee.maritalStatus);
            $('#ddlCountryEdit').val(employee.countryid);

            var dateOfBirth = employee.dateOfBirth.substr(1, 10);
            $('#dateOfBirthEdit').val(dateOfBirth);
            $('#cityEdit').val(employee.city);
            $('#addressEdit').val(employee.address);
            $('#phoneEdit').val(employee.phone);
            $('#emailEdit').val(employee.email);

            var hireDate = employee.hireDate.substr(1, 10);
            $('#hireDateEdit').val(hireDate);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
        });
        $('#editModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });

    $('.table #photoButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#photoModal #employeePhoto').attr('src', href);
        $('#photoModal').modal();
    });
});
