package popularbabyname;

public class BabyName {
    String babyName;
    String gender;
    int year;
    int rank;
    int count;

    public BabyName( String babyName, String gender, int year, int rank, int count) {
        this.babyName = babyName;
        this.gender = gender;
        this.year = year;
        this.rank = rank;
        this.count = count;
    }

    public String getBabyName() {
        return babyName;
    }

    public void setBabyName(String babyName) {
        this.babyName = babyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BabyName{" +
                ", babyName='" + babyName + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", rank=" + rank +
                ", count=" + count +
                '}';
    }
}
