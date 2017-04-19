var app = angular.module('registrationApp', []);
app.controller('register', function ($scope, $http) {
    $scope.account = new Account();
    $scope.register = function (type) {
        var account = $scope.account;
        account.type = type;
        register(account);
    };

    function register(account) {
        if (account.isValid()) {
            try {
                $http.post("/register?type=" + account.type, JSON.stringify(account))
                    .then(function (response) {
                        showSuccess();
                        $scope.account = new Account();
                    }, function (error) {
                        showError(error.data.message);
                    })
            } catch (error) {
                showError(error);
            }
        }
    };

    function Account() {
        this.firstname = "";
        this.lastname = "";
        this.email = "";
        this.password = "";
        this.type = "customer";
        this.isValid = function () {
            return this.firstname.length > 0
                && this.lastname.length > 0
                && this.email.length > 0
                && this.password.length > 0
        };
    };

    function showSuccess() {
        $(".alert-danger").hide();
        $(".alert-info").show();
    }

    function showError(error) {
        $(".alert-info").hide();
        $(".alert-danger").show();
        $scope.error = error;
    }
});