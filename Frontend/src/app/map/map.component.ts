import { Component, OnInit } from '@angular/core';
import { Loader } from '@googlemaps/js-api-loader';
import { styles } from './mapstyles';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  title = 'google-maps';

  private map: google.maps.Map | undefined

  ngOnInit(): void {
    let loader = new Loader({
      apiKey: 'AIzaSyBpFai8SWsOdBRDNrhxVEG85RZhDABzLmQ'
    })

    loader.load().then(() => {
      console.log('loaded gmaps')

      const location = { lat: -16.499721379876274 ,lng: -68.1378289887451 }

      // @ts-ignore
      this.map = new google.maps.Map(document.getElementById("map"), {
        center: location,
        zoom: 15,
        styles: styles
      })
      google.maps.event.addListener(this.map, 'click', function(event: { latLng: any; }) {
        const evt = event.latLng;
        console.log('latitude:'+evt.lat()+'; longitude:'+evt.lng()+';');
      });
    })
  }
}
