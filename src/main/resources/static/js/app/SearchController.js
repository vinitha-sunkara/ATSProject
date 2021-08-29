'use strict'

var app = angular.module('SimpleWebApp', []);
app.constant("CONSTANTS", {
    getCityByName: "/CityList",
    getAddressJsonByCityName: "/AddressJson",
    getFullJSONBySearch : "/FullJson"
});

app.controller("MainPageController", function ($scope, $http, CONSTANTS) {

    $scope.Cities = [];
    $scope.Addresses = [];

    //getCityList();
    //HTTP GET- get all City List
    /*function getCityList() {
        $http({
            method : 'GET',
            url : CONSTANTS.getCityByName
        }).then(function successCallback(response) {
            $scope.Cities = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }*/

    //For Faster Performance we call the JSON Function on Loading...Fetches all JSON Records
    /*  getAddressJSONList();

      //HTTP GET- get all Address JSON List
      function getAddressJSONList() {
          $scope.spinnerLoading = true;
          $scope.searchComplete = false;
          $http({
              method: 'GET',
              url: CONSTANTS.getAddressJsonByCityName
          }).then(function successCallback(response) {
              $scope.Addresses = response.data;
              var data = $scope.Addresses;
              console.log(data.length);

              //Conversion of ArrayList<String> Address JSONObjects From Backend to JSON Objects
              var jsonData = new Array();
              for (var i = 0; i < data.length; i++) {
                  jsonData.push(JSON.parse(data[i]));
                  console.log(jsonData[i].city);
              }
              console.log(jsonData);

              $scope.SearchResults = [];
              $scope.SearchResults = jsonData;
              $scope.spinnerLoading = false;
              $scope.searchComplete = true;

          }, function errorCallback(response) {
              console.log(response.statusText);
          });
      }*/

    getFullJSONList();
    //HTTP GET- get all Address JSON List
    function getFullJSONList() {
        $scope.spinnerLoading = true;
        $scope.searchComplete = false;
        $http({
            method: 'GET',
            url: CONSTANTS.getFullJSONBySearch
        }).then(function successCallback(response) {
            $scope.Addresses = response.data;
            var data = $scope.Addresses;
            console.log(data.length);

            //Conversion of ArrayList<String> Address JSONObjects From Backend to JSON Objects
            var jsonData = new Array();
            for (var i = 0; i < data.length; i++) {
                jsonData.push(JSON.parse(data[i]));
                console.log(jsonData[i].address.city);
            }
            console.log(jsonData);

            $scope.SearchResults = [];
            $scope.SearchResults = jsonData;
            $scope.spinnerLoading = false;
            $scope.searchComplete = true;

        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    $scope.getJsonObjBySearchInput = function () {
        $scope.filterExpr = $scope.searchText;
        //getAddressJSONList(); -- Slows Performance
    };


    //On Enter press - in Search Box Should Perform Search On Records.
    var input = document.getElementById("inptxt");
    input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            document.getElementById("submitbtn").click();
        }
    });

});