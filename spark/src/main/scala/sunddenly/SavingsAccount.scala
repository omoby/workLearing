package sunddenly

/**
  *
  * @ClassName SavingsAccount
  * @Author zhangqx02
  * @Date 2019/8/20 19:18
  * @Description
  *2. 扩展前一个练习的BankAccount类，新类SavingsAccount每个月都有利息产生( earnMonthlylnterest方法被调用 )，并且有每月三次免手续费的存款或取款。在eamMonthlylnterest方法中重置交易计数
  *
  */

class SavingsAccount(initialBalance:Double) extends  BankAccount (initialBalance:Double){
  private var freeCount = 3
  private val interestRate = 0.03
  def currentCount = freeCount

  def earnMonthlyInterest:Double={
    freeCount = 3
    super.deposite(super.deposite(0) * interestRate)
    super.deposite(0) * interestRate
  }

  override def deposite(amount: Double): Double = {
    if (freeCount >0){
      freeCount -= 1
      super.deposite(amount)
    }else{
      super.deposite(amount -1)
    }
  }

  override def withdraw(amount: Double): Double = {
    if (freeCount > 0){
      freeCount -= 1
      super.withdraw(amount)
    }else{
      super.withdraw(amount+1)
    }
  }

}

object SavingsAccount{
  val dbal = 1000
  val wbal = 100
  var interest = 0.0
  val sa = new SavingsAccount(1000)

  def main(args: Array[String]): Unit = {
    for(i <- 1 to 32){
      if (i >= 1 && i <= 4){
        sa.deposite(1000)
        println(i+"号存入: "+dbal+"余额: "+sa.currentBalance+"剩余免费次数: "+sa.currentCount)
      }else if(i >= 29 && i <= 30){
        if(i == 30)
          interest = sa.earnMonthlyInterest
        sa.withdraw(100)
        println(i+"取出入: "+dbal+"余额: "+sa.currentBalance+"剩余免费次数: "+sa.currentCount)

      }
    }
    println("一个月的利息为："+interest+" 剩余的免费次数："+sa.currentCount)
  }
}