import { Component, OnInit } from '@angular/core';
import { ServicesService } from '../services.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-create-note',
  templateUrl: './create-note.component.html',
  styleUrls: ['./create-note.component.css']
})
export class CreateNoteComponent implements OnInit{
  noteData = { title: '', description: '' };
  router: any;
  errorMessage: string = '';
  noteAddedSuccessfully: boolean = false;

  notes = { title: '', description: '' };
successMessage: any;

  constructor(private service: ServicesService) {}
  ngOnInit(): void {
    
  }

  //Validations which are required

  createNote(addPostForm: NgForm) {
    if (!this.notes.title) {
      this.errorMessage = 'This field is Mandatory';
      return;
    }

    if (this.notes.description.length > 500) {
      this.errorMessage = 'Description cannot exceed 500 letters.';
 return;
}


if (!/^[a-zA-Z@,;&*+\- ]*$/.test(this.notes.description)) {
 this.errorMessage = 'Only alphabetical letters (A-Z, a-z), spaces, and [@, ; & * + -] special characters are allowed in Description.';
 return;
}


    let newPost = {
      title: addPostForm.value.title,
      description: addPostForm.value.description,
      id: this.service.getUser().id
    };
  
    this.service.createNote(newPost).subscribe( 
      () => {
        
      console.log('Note created:', this.noteData);
      addPostForm.resetForm();
      this.noteAddedSuccessfully = true;
      setTimeout(() => {
        this.noteAddedSuccessfully = false;
      }, 3000);
      // Handle success or show a message to the user
    });
  }

  clearFields(form: NgForm) {
    this.noteData = { title: '', description: '' }; // Reset the data model
    form.resetForm(); // Reset the form
}
limitDescriptionLength(event: Event) {

  const target = event.target as HTMLTextAreaElement;

  if (target.value.length > 500) {

    target.value = target.value.slice(0, 500);

  }



}


logout() {
  this.service.logout();
  this.router.navigate(['login']);
}

loggedIn() {
  return this.service.isLogIn();
}

currentUser() {
  return this.service.getUser();
}
}


