package com.application.tuanlv.danhbadienthoai;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    Context context;
    List<ContactModel> listContacts;
    public ContactManager(Context context) {
        this.context = context;
        getContactData();
    }

    public List<ContactModel> getListContacts() {
        return listContacts;
    }

    private void getContactData() {
        listContacts = new ArrayList<>();
        String[] projections = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI};
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projections, null, null, null);
        if(cursor!=null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(projections[0]));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(projections[1]));
                String avatarUri = cursor.getString(cursor.getColumnIndex(projections[2]));
                Bitmap avatar = getPhotoFromUri(avatarUri);
                listContacts.add(new ContactModel(name, phoneNumber, avatar));
            } while(cursor.moveToNext());
        }
        cursor.close();
    }

    private Bitmap getPhotoFromUri(String avatarUri) {
        if(avatarUri!=null) {
            try {
                Bitmap avatar = MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(avatarUri));
                return avatar;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
