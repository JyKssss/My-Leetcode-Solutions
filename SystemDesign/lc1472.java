package SystemDesign;

public class lc1472 {
}

class BrowserHistory {
    VisitRecord curVisit;

    public BrowserHistory(String homepage) {
        curVisit = new VisitRecord(homepage, null, null);
    }

    public void visit(String url) {
        curVisit.forwardRecord = new VisitRecord(url, curVisit, null);
        curVisit = curVisit.forwardRecord;
    }

    public String back(int steps) {
        while (steps > 0 && curVisit.backRecord != null) {
            steps -= 1;
            curVisit = curVisit.backRecord;
        }
        return curVisit.getUrl();
    }

    public String forward(int steps) {
        while (steps > 0 && curVisit.forwardRecord != null) {
            steps -= 1;
            curVisit = curVisit.forwardRecord;
        }
        return curVisit.getUrl();
    }

    private class VisitRecord {
        String url;
        VisitRecord backRecord;
        VisitRecord forwardRecord;

        public VisitRecord(String url, VisitRecord backRecord, VisitRecord forwardRecord) {
            this.url = url;
            this.backRecord = backRecord;
            this.forwardRecord = forwardRecord;
        }

        public String getUrl() {
            return url;
        }

        public VisitRecord getBackRecord() {
            return backRecord;
        }

        public VisitRecord getForwardRecord() {
            return forwardRecord;
        }

    }
}
