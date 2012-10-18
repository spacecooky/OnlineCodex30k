package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RefreshListener;

public class ORPosaz extends Eintrag {

	AnzahlPanel Posaz;
	OptionsEinzelUpgrade MehrDakka;
	OptionsEinzelUpgrade Stärka;
	OptionsEinzelUpgrade Killamuni;
	OptionsEinzelZaehler Munigrotz;
	OptionsEinzelUpgrade Badrukk;
	OptionsEinzelUpgrade Dok;
	OptionsEinzelUpgrade Grotassistänt;
	OptionsEinzelUpgrade CybOrkKörpa;
	OptionsEinzelUpgrade madDokCybork;
	
	boolean BadrukkSelected = false;

	public ORPosaz() {

		kategorie = 5;

		grundkosten = 0;

		Posaz = new AnzahlPanel(ID, randAbstand, cnt, "Posaz", 5, 10, 25);
		add(Posaz);

		add(ico = new oc.Picture("oc/wh40k/images/Posaz.gif"));

		seperator();

		MehrDakka = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mehr Dakka", 5, Posaz.getModelle());
		add(MehrDakka);

		Stärka = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stärka", 5, Posaz.getModelle());
		add(Stärka);

		Killamuni = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Killamuni", 5, Posaz.getModelle());
		add(Killamuni);

		seperator();

		Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", 3, 5);
		add(Munigrotz);

		seperator();

		Badrukk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Badrukk", 135);
		add(Badrukk);

		seperator();

		Dok = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dok", 30);
		add(Dok);

		Grotassistänt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grotassistänt", 5);
		add(Grotassistänt);

		CybOrkKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Cybork-Körpa", 5, Posaz.getModelle());
		add(CybOrkKörpa);

		seperator();
		
		add(madDokCybork = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grotsniks Cybork-Körpa", Posaz.getModelle()*5));

		
		complete();

	}

	@Override
	public void deleteYourself() {
		if(BadrukkSelected) {
			BuildaHQ.setInformationVectorValue("ORBadrukk", -1);
		}
		super.deleteYourself();
	}
	
	
	//@OVERRIDE
	public void refreshen() {
		
		// Unique entry: Badrukk
		if (BadrukkSelected != Badrukk.isSelected()) {
			BadrukkSelected = !BadrukkSelected;

			if (BadrukkSelected) {
				BuildaHQ.addToInformationVector("ORBadrukk", 1);
			} else {
				BuildaHQ.addToInformationVector("ORBadrukk", -1);
			}
			RefreshListener.fireRefresh();
		}
		
		if (!Dok.isSelected()) {
			Grotassistänt.setAktiv(false);
			CybOrkKörpa.setAktiv(false);
		} else {
			Grotassistänt.setAktiv(true);
			CybOrkKörpa.setAktiv(true);
		}

		int Posazmodelle = Posaz.getModelle() - (Dok.isSelected() ? 1 : 0);
		int alleModelle = Posaz.getModelle() + (Badrukk.isSelected() ? 1 : 0);

		CybOrkKörpa.setModelle(alleModelle);
		MehrDakka.setModelle(Posazmodelle);
		Stärka.setModelle(Posazmodelle);
		Killamuni.setModelle(Posazmodelle);

		if(BuildaHQ.getCountFromInformationVector("ORDokGrotsnik")>0 && !CybOrkKörpa.isSelected()){
			madDokCybork.setAktiv(true);
			
		} else {
			madDokCybork.setAktiv(false);
			madDokCybork.setSelected(false);
		}
		
		madDokCybork.setPreis(alleModelle*5);
		
		if(madDokCybork.isSelected()){
			CybOrkKörpa.setAktiv(false);
		} else if (Dok.isSelected()){
			CybOrkKörpa.setAktiv(true);
		}

		Badrukk.setLegal(BuildaHQ.getCountFromInformationVector("ORBadrukk") < 2 || !Badrukk.isSelected());
	}
}
