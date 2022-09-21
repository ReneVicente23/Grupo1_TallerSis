import { Loader } from '@googlemaps/js-api-loader';

const loader = new Loader({
  apiKey: "AIzaSyBpFai8SWsOdBRDNrhxVEG85RZhDABzLmQ",
  version: "weekly",
  libraries: ["places"]
});

const mapOptions = {
  center: {
    lat: 0,
    lng: 0
  },
  zoom: 4
};

// Promise
loader
  .load()
  .then((google) => {
    new google.maps.Map(document.getElementById("map"), mapOptions);
  })
  .catch(e => {
    // do something
  });

  // Callback
loader.loadCallback(e => {
    if (e) {
      console.log(e);
    } else {
      new google.maps.Map(document.getElementById("map"), mapOptions);
    }
  });

function initMap() {
    // The location of Uluru
    const lapaz = { lat: -16.499721379876274, lng: -68.1378289887451 };
    // The map, centered at Uluru
    const map = new google.maps.Map(document.getElementById("map"), {
      zoom: 4,
      center: lapaz,
    });
    // The marker, positioned at Uluru
    const marker = new google.maps.Marker({
      position: lapaz,
      map: map,
    });
  }

  window.initMap = initMap;

