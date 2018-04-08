package motion.blevast.parser.vastad.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Creative implements Parcelable{

    private String id;


    protected Creative(Parcel in) {
    }

    public static final Creator<Creative> CREATOR = new Creator<Creative>() {
        @Override
        public Creative createFromParcel(Parcel in) {
            return new Creative(in);
        }

        @Override
        public Creative[] newArray(int size) {
            return new Creative[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public void setId(String id) {
        this.id = id;
    }
}
