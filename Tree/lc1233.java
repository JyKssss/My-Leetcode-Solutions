package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1233 {
    public List<String> removeSubfolders(String[] folder) {
        FileTree root = new FileTree();
        List<String> res = new ArrayList<>();
        for (String f : folder) {
            root.insert(f);
        }
        dfs(new StringBuilder(), res, root.childFileMap);
        return res;
    }

    private void dfs(StringBuilder pathBuilder, List<String> res, Map<String, FileTree> childFileMap) {
        for (Map.Entry<String, FileTree> fileTreeEntry : childFileMap.entrySet()) {
            pathBuilder.append(fileTreeEntry.getKey());
            if (fileTreeEntry.getValue().isEnd) {
                res.add(pathBuilder.toString());
            } else {
                pathBuilder.append("/");
                dfs(pathBuilder, res, fileTreeEntry.getValue().childFileMap);
                pathBuilder.delete(pathBuilder.length() - 1 ,pathBuilder.length());
            }
            pathBuilder.delete(pathBuilder.length() - fileTreeEntry.getKey().length(), pathBuilder.length());
        }
    }

    private class FileTree {
        boolean isEnd;
        Map<String, FileTree> childFileMap;

        public FileTree() {
            this.isEnd = false;
            this.childFileMap = new HashMap<>();
        }

        public void insert(String path) {
            String[] folders = path.split("/");
            FileTree cur = this;
            for (String folder : folders) {
                cur.childFileMap.putIfAbsent(folder, new FileTree());
                cur = cur.childFileMap.get(folder);
                if (cur.isEnd) {
                    break;
                }
            }
            cur.isEnd = true;
        }
    }
}
