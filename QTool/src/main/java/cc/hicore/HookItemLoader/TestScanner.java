package cc.hicore.HookItemLoader;

import cc.hicore.HookItemLoader.Annotations.MethodScanner;
import cc.hicore.HookItemLoader.Annotations.VerController;
import cc.hicore.HookItemLoader.Annotations.XPExecutor;
import cc.hicore.HookItemLoader.Annotations.XPItem;
import cc.hicore.HookItemLoader.bridge.BaseXPExecutor;
import cc.hicore.HookItemLoader.bridge.MethodContainer;
import cc.hicore.HookItemLoader.bridge.MethodFinderBuilder;
import cc.hicore.HookItemLoader.bridge.QQVersion;

@XPItem(name = "ScannerTest",itemType = XPItem.ITEM_Hook)
public class TestScanner {

    @VerController(targetVer = QQVersion.QQ_8_8_95)
    @MethodScanner
    public void TooHighScannerTest(MethodContainer container){

    }

    @VerController(targetVer = QQVersion.QQ_8_8_11)
    @MethodScanner
    public void MethodScannerTest(MethodContainer container) {
        container.addMethod(MethodFinderBuilder.newFinderByString("TestFinder","troopmemberinfo/#/#/#",m ->{
            return true;
        }));
        container.addMethod(MethodFinderBuilder.newFinderByString("TestFinder233333","onGetConfig | mDialogType = ",m ->{
            return true;
        }));
    }

    @VerController(targetVer = QQVersion.QQ_8_4_5)
    @MethodScanner
    public void testOldMethodScanner(MethodContainer container){

    }
}