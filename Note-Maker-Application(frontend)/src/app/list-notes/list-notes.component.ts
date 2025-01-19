import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { Router } from 'express';

@Component({
  selector: 'app-list-notes',
  templateUrl: './list-notes.component.html',
  styleUrls: ['./list-notes.component.css']
})
export class ListNotesComponent implements OnInit {

  notes: any[] = [];

  maxNotesToShow = 10;
  router: any;
  noteDeletedSuccessfully: boolean = false;

  constructor(private service: ServicesService) { }

  ngOnInit(): void {
    this.loadRecentNotes();
  }

  refreshCurrentRoute() {

    const currentUrl = this.router.url; // Get the current URL

    this.router.navigateByUrl('/refresh', { skipLocationChange: true }).then(() => {

      // Navigate back to the current URL without triggering a full page reload

      this.router.navigate([currentUrl]);

    });

  }


  loadRecentNotes(): void {

    this.service.getLatestNotes().subscribe(

      (data: any) => {

        this.notes = Array.isArray(data) ? data.slice(0, this.maxNotesToShow) : [];

      },

      (error: any) => {

        console.log(error);

      }

    );

  }


  deleteNote(id: any): void {

    if (confirm('Are you sure you want to delete this note?')) {

      this.service.deleteNote(id).subscribe({

        next: () => {

          // Remove the deleted note from the array

          this.notes = this.notes.filter((note) => note.id !== id);
          this.noteDeletedSuccessfully = true;


          // Check if there are fewer notes than the maximum count

          if (this.notes.length < this.maxNotesToShow) {

            // Fetch the latest note from the database

            this.service.getLatestNotes().subscribe({

              next: (latestNote) => {

                // Add the latest note to the beginning of the array

                this.notes.unshift(latestNote);

              },

              error: (err) => {

                console.log(err);

              }

            });

          }
          this.loadRecentNotes(); // Refresh the current route
          setTimeout(() => {
            this.noteDeletedSuccessfully = false;
          }, 3000);
        },

        error: (err) => {

          console.log('Error deleting note:', err);

        }

      });

    }

  }

  

currentUser() {
  return this.service.getUser();
}
}
