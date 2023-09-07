package jp.ac.meijou.android.s221205070;

import java.util.Map;

public class Gist {
    public Map<String, GistFile> files;

    public static class GistFile {
        public String content;
    }
}