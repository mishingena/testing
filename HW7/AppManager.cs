using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AutoItX3Lib;

namespace AutoTests {
    public class AppManager {
        public static string CALCULATOR = "Calculator";
        private string RunPath = @"C:\Windows\System32\calc.exe";
        
        AutoItX3 aux;
        OperationHelper operationHelper;

        public AutoItX3 Aux {
            get { return aux; }
        }

        public OperationHelper Operations {
            get { return operationHelper; }
        }

        public AppManager() {
            aux = new AutoItX3();
            aux.Run(RunPath);

            operationHelper = new OperationHelper(this);

            aux.WinWait(CALCULATOR);
            aux.WinActivate(CALCULATOR);
            aux.WinWaitActive(CALCULATOR);
        }

        public void Stop() {
            aux.WinClose(CALCULATOR);
        }        
    }
}
