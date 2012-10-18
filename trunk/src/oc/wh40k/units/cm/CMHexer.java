package oc.wh40k.units.cm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CMHexer extends Eintrag {

	OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade termi;
    OptionsEinzelUpgrade vdlk;
    OptionsUpgradeGruppe psi;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean tzeentchBool;

	public CMHexer() {
		name = "Hexer";
		grundkosten = 60;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));
		
		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 15));
		ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 15));
		add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 3", 50));
		add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(vdlk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran", "Veteranen des Langen Krieges", 5));
        
		seperator();
		
        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));
		
        seperator();
        
		termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "CMTerminatorwaffen", "");
		termiWaffen.initKammer(false, false, true);
		termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen  & Artefakte"));
		add(termiWaffen);
        
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CMWaffenUndArtefakte", "");
		// General, Hexer, Warpschmied, Apostel, Daemon 
		waffenUndArtefakte.initKammer(false, true, false, false, false);
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);
		
		seperator();
		
		chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosbelohnungen", "");
		chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), termi.isSelected(),false);
		chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(chaosBelohnungen);
		
		seperator();
		
		spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMSpezialausruestung", "");
		spezialAusruestung.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"));
		spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
		add(spezialAusruestung);

		complete();
	}

	@Override
	public void refreshen() {		
        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", mal.isSelected("Mal des Tzeentch") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", mal.isSelected("Mal des Nurgle") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", mal.isSelected("Mal des Slaanesh") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Seuchengranaten", mal.isSelected("Mal des Nurgle"));
        
        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));
        termiWaffen.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));
        
        spezialAusruestung.getKammer().switchEntry("Seuchengranaten", mal.isSelected("Mal des Nurgle"));
        spezialAusruestung.getKammer().switchEntry("Sprungmodul", !termi.isSelected());
        spezialAusruestung.getKammer().switchEntry("Chaosbike", !termi.isSelected());
        
        if(termi.isSelected()) {
        	waffenUndArtefakte.setAktiv(false);
        	termiWaffen.setAktiv(true);
        } else {
        	waffenUndArtefakte.setAktiv(true);
        	termiWaffen.setAktiv(false);
        }
        
		if(mal.isSelected("Mal des Tzeentch"))
		{
			if(tzeentchBool==false){
				tzeentchBool=true;
				BuildaHQ.addToInformationVector("CMTzeentchTroops", 1);
				BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Thousand Sons");
				BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Thousand Sons");
			}
		}
		
		if(!mal.isSelected("Mal des Tzeentch"))
		{
			if(tzeentchBool==true){
				tzeentchBool=false;
				BuildaHQ.addToInformationVector("CMTzeentchTroops", -1);
				if(BuildaHQ.getCountFromInformationVector("CMTzeentchTroops")<1){
				BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Thousand Sons");
				}
			}
		}
		
		((CMChaosbelohnungen)chaosBelohnungen.getKammer()).bikeGesetzt=((CMSpezialausruestung)spezialAusruestung.getKammer()).o2.isSelected();
		((CMSpezialausruestung)spezialAusruestung.getKammer()).reittierGesetzt=((CMChaosbelohnungen)chaosBelohnungen.getKammer()).o2.isSelected();
		if(((CMWaffenUndArtefakte)waffenUndArtefakte.getKammer()).uniqueError){
			setFehlermeldung("Artefakt doppelt!");
		} else{
			setFehlermeldung("");
		}
		
		waffenUndArtefakte.getPanel().setLocation(
				(int) waffenUndArtefakte.getPanel().getLocation().getX(),
				(int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
	    );
		
		chaosBelohnungen.getPanel().setLocation(
				(int) chaosBelohnungen.getPanel().getLocation().getX(),
				(int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
	    );
		
		spezialAusruestung.getPanel().setLocation(
				(int) spezialAusruestung.getPanel().getLocation().getX(),
				(int) chaosBelohnungen.getPanel().getLocation().getY() + chaosBelohnungen.getPanel().getSize().height + 5
	    );
    }
	
	@Override
	public void deleteYourself() {
		if(tzeentchBool==true){
			tzeentchBool=false;
			BuildaHQ.addToInformationVector("CMTzeentchTroops", -1);
			if(BuildaHQ.getCountFromInformationVector("CMTzeentchTroops")<1){
			BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Thousand Sons");
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Thousand Sons");
			}
		}
		super.deleteYourself();
	}
}
