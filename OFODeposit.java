import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class OFODeposit {

    public static void main(String[] args) {
        // 排队数据列表
        List<Queue> queues = new ArrayList();
        // 一天内随机时间数据，不准确
        // queues.add(new Queue(LocalDate.parse("2019-02-15"), 9286828));
        // queues.add(new Queue(LocalDate.parse("2019-02-18"), 9253814));
        // queues.add(new Queue(LocalDate.parse("2019-02-20"), 9237945));
        // queues.add(new Queue(LocalDate.parse("2019-02-25"), 9201359));
        // queues.add(new Queue(LocalDate.parse("2019-02-26"), 9193892));
        // queues.add(new Queue(LocalDate.parse("2019-02-27"), 9186375));
        // queues.add(new Queue(LocalDate.parse("2019-02-28"), 9176475));
        // 每天下午6点数据
        queues.add(new Queue(LocalDate.parse("2019-02-28"), 9176475));
        
        // 索引
        Integer index = null;
        for (int i = 2; i <= queues.size(); i++) {
            index = i - 1;
            // 天数间隔
            Long days = queues.get(index).getDate().toEpochDay() - queues.get(0).getDate().toEpochDay();
            // 名次间隔
            Integer rankings = queues.get(0).getRanking() - queues.get(index).getRanking();
            // 结果
            System.out.println("It's your turn in [" + queues.get(index).getRanking() / (rankings / days) + "] days, On " + queues.get(index).getDate() + ".");
        }
        if (queues.size() < 2) {
            System.out.println("queues.size() has to be greater than 2.");
        } else {
            System.out.println("done.");
        }
    }
}

/**
 * 排队情况
 */
class Queue {

    // 日期
    private LocalDate date;

    // 名次
    private Integer ranking;

    public Queue() {
    }

    public Queue(LocalDate date, Integer ranking) {
        this.date = date;
        this.ranking = ranking;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Queue date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getRanking() {
        return this.ranking;
    }

    public Queue ranking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    @Override
    public String toString() {
        return "Queue{date='" + getDate() + "'" + ", ranking='" + getRanking() + "'" + "}";
    }
}