import { Loader } from '@googlemaps/js-api-loader';

const loader = new Loader({
  apiKey: "",
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
    const uluru = { lat: -25.344, lng: 131.031 };
    // The map, centered at Uluru
    const map = new google.maps.Map(document.getElementById("map"), {
      zoom: 4,
      center: uluru,
    });
    // The marker, positioned at Uluru
    const marker = new google.maps.Marker({
      position: uluru,
      map: map,
    });
  }
  
  window.initMap = initMap;