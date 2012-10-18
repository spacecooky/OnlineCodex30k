package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;

public class SMVaylundCal extends Eintrag {

	public SMVaylundCal() {
		name = "Vaylund Cal";
		grundkosten = 215;
                
		BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", 1);
		BuildaHQ.addToInformationVector("SMChapterMaster", 1);
                                
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ehrwürdiger Cybot");
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Cybot");
                BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Ironclad-Cybot");

		add(ico = new oc.Picture("oc/wh40k/images/SMKorsarroKhan.gif"));
                
		complete();
	}

	@Override
	public void deleteYourself() {
		
                BuildaHQ.addToInformationVector("SMChapterMaster", -1);
                BuildaHQ.addToInformationVector("SMOnlyOneChapterMaster", -1);

                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ehrwürdiger Cybot");
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Cybot");
                BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("Ironclad-Cybot");
            
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
            setUnikat(true);
            
            if(BuildaHQ.getCountFromInformationVector("SMChapterMaster") > 1 && BuildaHQ.getCountFromInformationVector("SMOnlyOneChapterMaster") > 0) {
                setFehlermeldung("nur ein Ordensmeister");
            } else {
                setFehlermeldung("");
            }
            
            
            
        }

}
