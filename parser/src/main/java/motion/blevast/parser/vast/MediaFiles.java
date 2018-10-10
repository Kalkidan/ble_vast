package motion.blevast.parser.vast;


import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class MediaFiles {

    public static final Object MEDIA_FILE = "MediaFile";

    @Tag("MediaFile") private List<MediaFile> mediaFileList = new ArrayList<>();

    public List<MediaFile> getMediaFileList() {
        return mediaFileList;
    }

    public void setMediaFileList(MediaFile mediaFile) {
        this.mediaFileList.add(mediaFile);
    }
}
