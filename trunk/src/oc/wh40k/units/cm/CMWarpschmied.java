package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CMWarpschmied extends Eintrag {

	OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade vdlk;
    RuestkammerStarter nahkampfWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter spezialAusruestung;

	public CMWarpschmied() {
		name = "Warpschmied";
		grundkosten = 110;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 15));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(vdlk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran", "Veteranen des Langen Krieges", 5));

		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CMWaffenUndArtefakte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndArtefakte.initKammer(false, false, true, false, false);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
				
		seperator();
		
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosbelohnungen", "");
		chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), false,false);
		chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(chaosBelohnungen);
		
		complete();
	}

	@Override
	public void refreshen() {
        chaosBelohnungen.getKammer().switchEntry("Moloch des Khorne", false);
        chaosBelohnungen.getKammer().switchEntry("Flugd�mon des Tzeentch", false);
        chaosBelohnungen.getKammer().switchEntry("S�nfte des Nurgle", false);
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", false);
        
        waffenUndArtefakte.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("Mal des Khorne"));
        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));
    
        if(((CMWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
	}

}
