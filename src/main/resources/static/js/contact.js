$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (contact, status) {
            $('#idEdit').val(contact.id);
            $('#firstNameEdit').val(contact.firstName);
            $('#lastNameEdit').val(contact.lastName);
            $('#phoneEdit').val(contact.phone);
            $('#emailEdit').val(contact.email);
            $('#remarksEdit').val(contact.remarks);
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
