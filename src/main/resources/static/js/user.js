$(document).ready(function() {
    $('.table .detailsButton').on('click', function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(user, status){
            $('#idDetails').val(user.id);
            $('#firstNameDetails').val(user.firstName);
            $('#lastNameDetails').val(user.lastName);
            $('#usernameDetails').val(user.username);
            $('#passwordDetails').val(user.password);
        });
        $('#detailsModal').modal();
    });

    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});