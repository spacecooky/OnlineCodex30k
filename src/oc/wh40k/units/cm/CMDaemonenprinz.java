package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CMDaemonenprinz extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsUpgradeGruppe mal;
	OptionsUpgradeGruppe psi;
	RuestkammerStarter chaosBelohnungen;
	RuestkammerStarter waffenUndArtefakte;

	public CMDaemonenprinz() {
		name = "D�monenprinz";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/DaemonPrince.gif"));
		
		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fl�gel", 40));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servor�stung", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("D�mon des Khorne", 15));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Tzeentch", 15));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("D�mon des Slaanesh", 10));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 1", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 50));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 3", 75));
		add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosbelohnungen", "");
		chaosBelohnungen.initKammer(mal.isSelected("D�mon des Khorne"), mal.isSelected("D�mon des Tzeentch"), mal.isSelected("D�mon des Nurgle"), mal.isSelected("D�mon des Slaanesh"), false,true);
		chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(chaosBelohnungen);
		
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CMWaffenUndArtefakte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndArtefakte.initKammer(false, false, false, false, true);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
		
		complete();
	}

	@Override
	public void refreshen() {
        if(mal.getAnzahl() < 1) {
            mal.setLegal(false);
            setFehlermeldung("W�hle einen Gott");
        } else {
            mal.setLegal(true);
            setFehlermeldung("");
        }
        
        if (mal.isSelected("D�mon des Khorne")) {
			psi.setAktiv(false);
		} else {
			psi.setAktiv(true);
		}
        
        //waffenUndArtefakte.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("D�mon des Khorne"));
        //waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("D�mon des Tzeentch"));
        
        if(((CMWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
    }

}
