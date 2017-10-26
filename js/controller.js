$.ajax({
    url:'mock.json',
    dataType:'json',
    type: 'get',
    cache:false,
    success:function (data) {
        $(data).each(function (index,value) {
            document.getElementById('price-ios').innerHTML = 'מחיר: '+ value.ios;
            document.getElementById('price-android').innerHTML = 'מחיר: '+ value.android;
        });
    }
});

function BuyProduct () {
    var ios = document.getElementById("ios-number");
    var iosNumber = Number(ios.options[ios.selectedIndex].value);
    console.log(iosNumber)

    var android = document.getElementById("android-number");
    var androidNumber = Number(android.options[android.selectedIndex].value);
    console.log(androidNumber)



}
