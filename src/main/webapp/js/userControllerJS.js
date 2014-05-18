


/*angular.module('userApp.services',['ngResource'])
        .factory('AngularIssues',function($resource)
        {

            return $resource('https://api.github.com/repos/angular/angular.js/issues',{})

        }).value('verion','0.1');
  */

  //function() {
           var serviceModule = angular.module('userAppservices', ['ngResource'])

            console.log("prior to calling twitter service..........................");

          this.getTweetsCount =  serviceModule.factory('twitter', function ($resource, $http) {
              var consumerKey = encodeURIComponent('yCYjpCULEM3ysm7OAv1rh24Xi')
              var consumerSecret = encodeURIComponent('jLEkZ4cVm3dnwqu6HLC8jiGtcmIDLKwIn67UHy2u0M9sQtsj5P')
              var credentials = Base64.encode(consumerKey + ':' + consumerSecret)
              // Twitters OAuth service endpoint
              var twitterOauthEndpoint = $http.post(
                  'https://api.twitter.com/oauth2/token'
                  , "grant_type=client_credentials"
                  , {headers: {'Authorization': 'Basic ' + credentials, 'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}}
              )
              twitterOauthEndpoint.success(function (response) {
                  // a successful response will return
                  // the "bearer" token which is registered
                  // to the $httpProvider
                  serviceModule.$httpProvider.defaults.headers.common['Authorization'] = "Bearer " + response.access_token
              }).error(function (response) {
                    // error handling to some meaningful extent
                  })

              var r = $resource('https://api.twitter.com/1.1/search/:action',
                  {action: 'tweets.json',
                      count: 10,
                  },
                  {
                                 paginate: {method: 'GET'}
                  })

              return r;
          }

          .config(function ($httpProvider) {
             serviceModule.$httpProvider = $httpProvider
          })
 // }

//angular.module('myApp.controllers',[]).controller('userController',['$scope','AngularIssues',function($scope,
//AngularIssues){
//
//    $scope.data={};
//
//  debugger;
//    AngularIssues.query(function(response){
//
//       $scope.data.issues = response;
//    });
//
//}])
//.controller('MyCtrl2', [function() {
//  }]);



app.controller('CalculatorController', function($scope, userAppservices) {

console.log("Inside Calculator service................");
 
    $scope.getTweets = function(){

                          userAppservices.

    }



//    $scope.doSquare = function() {
//        $scope.answer = CalculatorService.square($scope.number);
//    }
// 
//    $scope.doCube = function() {
//        $scope.answer = CalculatorService.cube($scope.number);
//    }
});