using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutoTests {
    public class OperationHelper : HelperBase {
        public OperationHelper(AppManager manager) : base(manager) { }

        public void EnterNumber(int number) {
            int a = Math.Abs(number);
            AddNumber(a);

            if (number < 0) {
                AddSign("+-");
            }
        }


        public void EnterNumber(double number) {            
            string[] numberSplit = number.ToString().Split(',');
            int a = Convert.ToInt32(numberSplit[0]);
            int b = Convert.ToInt32(numberSplit[1]);
            AddNumber(a);
            AddSign(",");
            AddNumber(b);

            if (number < 0) {
                AddSign("+-");
            }
        }


        private void AddNumber(int number) {
            switch (number) {
                case 0:
                    aux.ControlClick(CALCULATOR, "", "Button6");
                    break;
                case 1:
                    aux.ControlClick(CALCULATOR, "", "Button5");
                    break;
                case 2:
                    aux.ControlClick(CALCULATOR, "", "Button11");
                    break;
                case 3:
                    aux.ControlClick(CALCULATOR, "", "Button16");
                    break;
                case 4:
                    aux.ControlClick(CALCULATOR, "", "Button4");
                    break;
                case 5:
                    aux.ControlClick(CALCULATOR, "", "Button10");
                    break;
                case 6:
                    aux.ControlClick(CALCULATOR, "", "Button15");
                    break;
                case 7:
                    aux.ControlClick(CALCULATOR, "", "Button3");
                    break;
                case 8:
                    aux.ControlClick(CALCULATOR, "", "Button9");
                    break;
                case 9:
                    aux.ControlClick(CALCULATOR, "", "Button14");
                    break;
                default:
                    break;
            }

        }

        public void AddSign(string sign) {
            switch (sign) {
                case "+":
                    aux.ControlClick(CALCULATOR, "", "Button23");
                    break;
                case "-":
                    aux.ControlClick(CALCULATOR, "", "Button22");
                    break;
                case "*":
                    aux.ControlClick(CALCULATOR, "", "Button6");
                    break;
                case "/":
                    aux.ControlClick(CALCULATOR, "", "Button6");
                    break;
                case "+-":
                    aux.ControlClick(CALCULATOR, "", "Button19");
                    break;
                case ",":
                    aux.ControlClick(CALCULATOR, "", "Button17");
                    break;
                case "SQR":
                    aux.ControlClick(CALCULATOR, "", "Button25");
                    break;
                default:
                    break;
            }
        }

        public void Result() {
            aux.ControlClick(CALCULATOR, "", "Button28");
        }

        public string GetResult() {
            string one = aux.ControlGetText(CALCULATOR, "", "#327701");
            string two = aux.WinGetText(CALCULATOR);
            return aux.WinGetText(CALCULATOR).Replace("\n", "");
        }

        public string Calculate(OperationDataInt items) {
            int result = 0;
            switch (items.Sign) {
                case "+":
                    result = items.First + items.Second;
                    break;
                case "-":
                    result = items.First - items.Second;
                    break;
                case "*":
                    result = items.First * items.Second;
                    break;
                case "/":
                    result = items.First / items.Second;
                    break;
                default:
                    break;
            }
            return result.ToString();
        }

        public string Calculate(OperationDataDouble items) {
            double result = 0;
            switch (items.Sign) {
                case "+":
                    result = items.First + items.Second;
                    break;
                case "-":
                    result = items.First - items.Second;
                    break;
                case "*":
                    result = items.First * items.Second;
                    break;
                case "/":
                    result = items.First / items.Second;
                    break;
                case "SQR":
                    result = Math.Sqrt(items.First);
                    break;
                default:
                    break;
            }
            return result.ToString();
        }

        public string CalculateFunction(OperationDataInt items) {
            double result = 0;
            switch (items.Sign) {
                case "SQR":
                    result = Math.Sqrt(items.First);
                    break;
                default:
                    break;
            }
            return result.ToString();
        }
    }
}
