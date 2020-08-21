package top.fengleifeng.question;

import java.util.TreeSet;

/**
 * @program: leetcode-test
 * @description: 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 * 通过次数1,892提交次数5,214
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: fengleifeng
 * @create: 2020-08-20 17:56
 **/
public class Num855考场就座 {


/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

}

class ExamRoom {

    int N;
    TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.N = N;
        students = new TreeSet();
    }

    public int seat() {
        //Let's determine student, the position of the next
        //student to sit down.
        int student = 0;
        if (students.size() > 0) {
            //Tenatively, dist is the distance to the closest student,
            //which is achieved by sitting in the position 'student'.
            //We start by considering the left-most seat.
            int dist = students.first();
            Integer prev = null;
            for (Integer s : students) {
                if (prev != null) {
                    //For each pair of adjacent students in positions (prev, s),
                    //d is the distance to the closest student;
                    //achieved at position prev + d.
                    int d = (s - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        student = prev + d;
                    }
                }
                prev = s;
            }

            //Considering the right-most seat.
            if (N - 1 - students.last() > dist)
                student = N - 1;
        }

        //Add the student to our sorted TreeSet of positions.
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }


    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        int seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
        seat = examRoom.seat();
        System.out.println(seat);
    }
}