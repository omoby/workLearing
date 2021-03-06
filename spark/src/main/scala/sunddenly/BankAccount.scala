package sunddenly

/**
  *
  * @ClassName BankAccount
  * @Author zhangqx02
  * @Date 2019/8/20 19:07
  * @Description
  *1. 扩展如下的BankAccount类，新类CheckingAccount对每次存款和取款都收取1美元的手续费
  *
  * class BankAccount ( initialBalance: Double) {
  *
  * private var balance = initialBalance
  *
  * def deposit (amount: Double) = { balance += amount; balance }
  *
  * def withdraw(amount: Double)={ balance -= amount; balance }
  *
  * }
  *
  */

class BankAccount(initialBalance:Double) {
  private var balance = initialBalance
  def deposite(amount:Double)={
    balance += amount
    balance
  }
  def withdraw(amount:Double)={
    balance -= amount
    balance
  }
  def currentBalance = balance

}

class CheckingAccount(initialBalance:Double) extends BankAccount(initialBalance:Double){
  override def deposite(amount: Double): Double = super.deposite(amount-1)

  override def withdraw(amount: Double): Double = super.withdraw(amount+1)
}

object CheckingAccount{
  val cha = new CheckingAccount(1000)
  val dbal  = 1000
  val wbal = 800

  def main(args: Array[String]): Unit = {
    println("当前余额： "+ cha.currentBalance)
    cha.deposite(dbal)
    println("存入："+dbal+ " 后余额为： "+cha.currentBalance)
    cha.withdraw(wbal)
    println("取出： "+wbal+" 后余额为："+cha.currentBalance)
  }
}
