$(function() {

    var date = '2018-10-10';
    var enabledLayers = [];
    var enabledLayersNames = [];
    var bounds = [[35.98245136, -112.26379395], [36.13343831, -112.10998535]];

    var getLocation = function(location) {
        $.getJSON("https://www.mapquestapi.com/geocoding/v1/address?key=RvBffXAzY3Wu7GCGYAOuXnsAbZRPu6YA&location=" + location, function(data) {
            var markers = [];
            var features = data.features;
            console.log(data);
            console.log(data.results[0].locations[0].latLng);

            earth.panInsideBounds([[data.results[0].locations[0].latLng.lat - 3, data.results[0].locations[0].latLng.lng - 3],
                    [data.results[0].locations[0].latLng.lat + 3, data.results[0].locations[0].latLng.lng + 3]],
                {heading: 0, tilt: 0, duration: 2});
            //earth.setView([data.results[0].locations[0].latLng.lat, data.results[0].locations[0].latLng.lng], 7);

        });
    }

    function getAnswer(cadena){
        var xmlHttp= new XMLHttpRequest();
        xmlHttp.open("GET",'/new/'+cadena,false);
        xmlHttp.send();
        return xmlHttp.responseText;
    }

    function parseAnswer(cadena){
        var obj=JSON.parse(cadena);
        console.log(obj.reconocido);
        console.log(obj.accion);
        return obj.accion;
    }

    $("#datepicker").datepicker({
        dateFormat: "yy-mm-dd",
        onSelect: function(dateText) {
            var auxLayers = [];
            $.each(enabledLayers, function(index, layer) {
                if (enabledLayersNames[index]!='base'){
                    layer.removeFrom(earth);
                    var new_layer = addLayer(enabledLayersNames[index], dateText);
                    new_layer.addTo(earth);
                    auxLayers.push(new_layer);
                }
            });
            enabledLayers = auxLayers;
        }
    });

    $("#date_form").hide();

    earth = new WE.map('earth_div');
    earth.setView([46.8011, 8.2266], 2);
    var toner = WE.tileLayer('https://stamen-tiles.a.ssl.fastly.net/toner/{z}/{x}/{y}.png', {
        attribution: 'Map tiles by Stamen Design, under CC BY 3.0. Data by OpenStreetMap, under CC BY SA.',
        opacity: 1.0
    });
    toner.addTo(earth);
    enabledLayers.push(toner);
    enabledLayersNames.push('base');
    var nivelZoom=2;

    function act(cadena){
        cadena="mapa "+cadena;
        document.getElementById("reconocido").innerHTML="Reconocido: "+cadena;
        var answer=parseAnswer(getAnswer(cadena));
        switch(answer){
            case "mover arriba":
                console.log("Report");
                console.log(10/(nivelZoom*nivelZoom));
                console.log(earth.getCenter());
                console.log(earth.getCenter()[0]+200/(nivelZoom*nivelZoom));
                earth.panTo([earth.getCenter()[0]+(200/(nivelZoom*nivelZoom)),earth.getCenter()[1]]);
                break;
            case "mover abajo":
                earth.panTo([earth.getCenter()[0]-200/(nivelZoom*nivelZoom),earth.getCenter()[1]]);
                break;
            case "mover izquierda":
                earth.panTo([earth.getCenter()[0],earth.getCenter()[1]-(200/(nivelZoom*nivelZoom))]);
                break;
            case "mover derecha":
                earth.panTo([earth.getCenter()[0],earth.getCenter()[1]+(200/(nivelZoom*nivelZoom))]);
                break;
            case "mover abajo derecha":
                earth.panTo([earth.getCenter()[0]-(200/(nivelZoom*nivelZoom)),earth.getCenter()[1]+(200/(nivelZoom*nivelZoom))]);
                break;
            case "mover abajo izquierda":
                earth.panTo([earth.getCenter()[0]-200/(nivelZoom*nivelZoom),earth.getCenter()[1]-200/(nivelZoom*nivelZoom)]);
                break;
            case "mover arriba derecha":
                earth.panTo([earth.getCenter()[0]+200/(nivelZoom*nivelZoom),earth.getCenter()[1]+200/(nivelZoom*nivelZoom)]);
                break;
            case "mover arriba izquierda":
                earth.panTo([earth.getCenter()[0]+200/(nivelZoom*nivelZoom),earth.getCenter()[1]-200/(nivelZoom*nivelZoom)]);
                break;
            case "satelite":
                var layer = addLayer('MODIS_Terra_Land_Surface_Temp_Day', '2018-10-10');
                enabledLayers.push(layer);
                enabledLayersNames.push('MODIS_Terra_Land_Surface_Temp_Day');
                layer.addTo(earth);
                break;
            case "zoom in":
                earth.zoomIn();
                nivelZoom=nivelZoom+1;
                break;
            case "zoom out":
                earth.zoomOut();
                nivelZoom=nivelZoom-1;
                if(nivelZoom<1){nivelZoom=1;}
                break;
            default:
                //Tratar busqueda
                if(answer==null){
                    console.log('Respuesta vacia');
                    break;
                }
                getLocation(answer.substring(answer.indexOf(' ')));
        }
    }

		if (!annyang){
			alert('Speech Recognition Engine not suported (Try Google Chrome)')
		} else {

        var commands = {
            'mapa *resto': act,
            'para ya': function(){
                console.log('Acabar ejecucion');
                annyang.abort;
            }
        };

        // Add our commands to annyang
				annyang.debug();
        annyang.setLanguage('es-ES');
        annyang.addCommands(commands);

        annyang.addCallback('start', function(e) {
            console.log('Start', e);
        });

				annyang.addCallback('end', function(e) {
						console.log('End', e);
				});

        annyang.addCallback('error', function(e) {

            console.log('Error', e);
						alert('annyang error code: ' + e.error + '\n' + e.message)
        });

        annyang.addCallback('soundstart', function(e) {
            console.log('Soundstart', e);
        });


        // Start listening. You can call this here, or attach this call to an event, button, etc.
        annyang.start({
            autoRestart: true,
            continuous: false
        });
    }
});


