package SystemDesign;

import java.util.*;

public class MarathonBoard {
    int numRunner;
    int numSensor;
    int firstSensor;
    RunnerNode[] sensorArray;
    Map<Integer, RunnerNode> runnerNodeMap;
    public MarathonBoard(int numRunner, int numSensor) {
        this.numRunner = numRunner;
        this.numSensor = numSensor;
        this.firstSensor = 0;
        this.sensorArray = new RunnerNode[numSensor];
        this.runnerNodeMap = new HashMap<>();
        for (int i = 0; i < sensorArray.length; i++) {
            sensorArray[i] = new RunnerNode(-1);
        }
    }

    public void update(int runnerID, int sensorID) {
        if (runnerNodeMap.containsKey(runnerID)) {
            delRunner(runnerID);
        }
        addRunner(runnerID, sensorID);
        firstSensor = Math.max(firstSensor, sensorID);
    }

    public List<Integer> getRank(int k) {
        int count = k;
        int index = firstSensor;
        List<Integer> res =new ArrayList<>();

        while (count > 0 && index >= 0) {
            RunnerNode curRunner = sensorArray[index].next;
            while (curRunner != null && count > 0) {
                res.add(curRunner.runnerID);
                curRunner = curRunner.next;
                count -= 1;
            }
            index -= 1;
        }
        return res;
    }

    private void addRunner(int runnerID, int sensorID) {
        RunnerNode runner = runnerNodeMap.getOrDefault(runnerID, null);
        if(runner == null) {
            runner = new RunnerNode(runnerID);
            runnerNodeMap.put(runnerID, runner);
        }
        RunnerNode cur = sensorArray[sensorID];
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = runner;
        runner.prev = cur;

    }

    private void delRunner(int runnerID) {
        RunnerNode runner = runnerNodeMap.get(runnerID);
        runner.prev.next = runner.next;
        runner.next.prev = runner.prev;
        runner.prev = null;
        runner.next = null;
    }

    private class RunnerNode {
        int runnerID;
        RunnerNode prev;
        RunnerNode next;

        public RunnerNode(int runnerID) {
            this.runnerID = runnerID;
        }
    }
}
