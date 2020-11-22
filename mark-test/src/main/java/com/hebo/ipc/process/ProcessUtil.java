package com.hebo.ipc.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Set;

public class ProcessUtil {
    public static void main(String[] args) throws InterruptedException {
        String a=new StringBuilder().append("计算机").append("基础").toString();
        System.out.println(a.intern()==a);
         a=new StringBuilder().append("ja").append("va").toString();
        System.out.println(a.intern()==a);
        System.out.println(getProcessID());
//        while(true) {
//            Thread.sleep(10000);
//        }
    }

    public static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }
//    public static void getProcessIDs() throws Exception {
//        // 获取监控主机
//        MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
//        // 取得所有在活动的虚拟机集合
//        Set<?> vmlist = new HashSet<Object>(local.activeVms());
//        // 遍历集合，输出PID和进程名
//        for(Object process : vmlist) {
//            MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
//            // 获取类名
//            String processname = MonitoredVmUtil.mainClass(vm, true);
//            System.out.println(process + " ------> " + processname);
//        }
//    }
}
