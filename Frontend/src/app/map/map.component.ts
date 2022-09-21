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
        zoom: 6,
        styles: styles
      })
      const marker = new google.maps.Marker({
        position: location,
        map: this.map,
        draggable: true
      });
      google.maps.event.addListener(marker, 'dragend', function(evt: { latLng: { lat: () => number; lng: () => number; }; }){
        // @ts-ignore
        document.getElementById('current').innerHTML = '<p>Marker dropped: Current Lat: ' + evt.latLng.lat().toFixed(3) + ' Current Lng: ' + evt.latLng.lng().toFixed(3) + '</p>';
      });

      google.maps.event.addListener(marker, 'dragstart', function(evt: { latLng: { lat: () => number; lng: () => number; }; }){
        // @ts-ignore
        document.getElementById('current').innerHTML = '<p>Currently dragging marker...</p>';
      });
    })
  }
}
