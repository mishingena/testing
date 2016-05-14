using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using NUnit.Framework;

namespace AutoTests
{
    [TestFixture]
    public class OperationTests : TestBase {
        [Test]
        public void SumTest() {
            OperationDataInt items = new OperationDataInt() {First = 2, Sign = "+", Second = 3};

            manager.Operations.EnterNumber(items.First);
            manager.Operations.AddSign(items.Sign);
            manager.Operations.EnterNumber(items.Second);
            manager.Operations.Result();

            string result = manager.Operations.GetResult();
            string shouldBe = manager.Operations.Calculate(items);

            NUnit.Framework.Assert.AreEqual(result, shouldBe);
        }

        [Test]
        public void DevisionTest() {
            OperationDataInt items = new OperationDataInt() {First = 100500, Sign = "/", Second = 5};

            manager.Operations.EnterNumber(items.First);
            manager.Operations.AddSign(items.Sign);
            manager.Operations.EnterNumber(items.Second);
            manager.Operations.Result();

            string result = manager.Operations.GetResult();
            string shouldBe = manager.Operations.Calculate(items);

            NUnit.Framework.Assert.AreEqual(result, shouldBe);
        }

        [Test]
        public void SQRTest() {
            OperationDataInt items = new OperationDataInt() {First = 4, Sign = "SQR"};

            manager.Operations.EnterNumber(items.First);
            manager.Operations.AddSign(items.Sign);
            manager.Operations.Result();

            string result = manager.Operations.GetResult();
            string shouldBe = manager.Operations.CalculateFunction(items);

            NUnit.Framework.Assert.AreEqual(result, shouldBe);
        }
    }
}
