package com.zsgs.LibraryManagement.librarysetup;

import com.zsgs.LibraryManagement.datalayer.LibraryDatabase;
import com.zsgs.LibraryManagement.model.Library;

class LibrarySetupModel {
	private LibrarySetupView librarySetupView;
	
	private Library library;
	
	LibrarySetupModel(LibrarySetupView librarySetupView){
		this.librarySetupView=librarySetupView;
		library=LibraryDatabase.getInstance().getLibrary();
		}
	public void startSetup() {
		if(library ==null ||library.getId()==0) {
			librarySetupView.initiateSetup();
		} else {
			librarySetupView.onSetupComplete(library);
		}
		
	}
	public void createLibrary(Library library) {
		
		if (library.getName().length() <3  || library.getName().length() > 50) {
			librarySetupView.showAlert("Enter valid name");
			return;
		}
		this.library = LibraryDatabase.getInstance().insertLibrary(library);
		LibraryDatabase.getInstance().serializeLibrary(library);
		librarySetupView.onSetupComplete(library);
	}
	
	
}
